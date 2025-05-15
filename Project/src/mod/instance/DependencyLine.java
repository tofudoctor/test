package mod.instance;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

import javax.swing.JPanel;

import Define.AreaDefine;
import Pack.DragPack;
import bgWork.handler.CanvasPanelHandler;
import mod.IFuncComponent;
import mod.ILinePainter;

public class DependencyLine extends JPanel implements IFuncComponent, ILinePainter {
    JPanel from;
    int fromSide;
    Point fp = new Point(0, 0);

    JPanel to;
    int toSide;
    Point tp = new Point(0, 0);

    boolean isSelect = false;
    int selectBoxSize = 5;

    CanvasPanelHandler cph;

    public DependencyLine(CanvasPanelHandler cph) {
        this.setOpaque(false);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(1, 1));
        this.cph = cph;
    }

    @Override
    public void paintComponent(Graphics g) {
        renewConnect();

        Graphics2D g2d = (Graphics2D) g;

        Point fpPrime = new Point(fp.x - getLocation().x, fp.y - getLocation().y);
        Point tpPrime = new Point(tp.x - getLocation().x, tp.y - getLocation().y);

        // 畫虛線
        Stroke dashed = new BasicStroke(1.5f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_BEVEL, 0, new float[] { 6 }, 0);
        g2d.setStroke(dashed);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(fpPrime.x, fpPrime.y, tpPrime.x, tpPrime.y);

        // 畫箭頭
        paintArrow(g2d, tpPrime);

        if (isSelect) {
            paintSelect(g2d);
        }
    }

    @Override
    public void reSize() {
        Dimension size = new Dimension(Math.abs(fp.x - tp.x) + 10, Math.abs(fp.y - tp.y) + 10);
        this.setSize(size);
        this.setLocation(Math.min(fp.x, tp.x) - 5, Math.min(fp.y, tp.y) - 5);
    }

    @Override
    public void paintArrow(Graphics g, Point tip) {
        Graphics2D g2d = (Graphics2D) g;

        int len = 10;
        double angle = Math.atan2(tp.y - fp.y, tp.x - fp.x);

        int x1 = (int) (tip.x - len * Math.cos(angle - Math.PI / 6));
        int y1 = (int) (tip.y - len * Math.sin(angle - Math.PI / 6));
        int x2 = (int) (tip.x - len * Math.cos(angle + Math.PI / 6));
        int y2 = (int) (tip.y - len * Math.sin(angle + Math.PI / 6));

        g2d.drawLine(tip.x, tip.y, x1, y1);
        g2d.drawLine(tip.x, tip.y, x2, y2);
    }

    @Override
    public void setConnect(DragPack dPack) {
        Point mfp = dPack.getFrom();
        Point mtp = dPack.getTo();
        from = (JPanel) dPack.getFromObj();
        to = (JPanel) dPack.getToObj();
        fromSide = new AreaDefine().getArea(from.getLocation(), from.getSize(), mfp);
        toSide = new AreaDefine().getArea(to.getLocation(), to.getSize(), mtp);
        renewConnect();
        System.out.println("DependencyLine from side " + fromSide);
        System.out.println("DependencyLine to side " + toSide);
    }

    void renewConnect() {
        try {
            fp = getConnectPoint(from, fromSide);
            tp = getConnectPoint(to, toSide);
            reSize();
        } catch (NullPointerException e) {
            this.setVisible(false);
            cph.removeComponent(this);
        }
    }

    Point getConnectPoint(JPanel jp, int side) {
        Point temp = new Point(0, 0);
        Point jpLocation = cph.getAbsLocation(jp);
        if (side == new AreaDefine().TOP) {
            temp.x = (int) (jpLocation.x + jp.getWidth() / 2);
            temp.y = jpLocation.y;
        } else if (side == new AreaDefine().RIGHT) {
            temp.x = jpLocation.x + jp.getWidth();
            temp.y = (int) (jpLocation.y + jp.getHeight() / 2);
        } else if (side == new AreaDefine().LEFT) {
            temp.x = jpLocation.x;
            temp.y = (int) (jpLocation.y + jp.getHeight() / 2);
        } else if (side == new AreaDefine().BOTTOM) {
            temp.x = (int) (jpLocation.x + jp.getWidth() / 2);
            temp.y = jpLocation.y + jp.getHeight();
        } else {
            temp = null;
            System.err.println("getConnectPoint fail: " + side);
        }
        return temp;
    }

    @Override
    public void paintSelect(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(fp.x, fp.y, selectBoxSize, selectBoxSize);
        g.fillRect(tp.x, tp.y, selectBoxSize, selectBoxSize);
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }
}
