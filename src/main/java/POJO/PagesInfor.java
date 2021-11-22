package POJO;
public class PagesInfor {
    private int totle;
    private int pagebegin;
    private int pageend;
    public int getTotle() {
        return totle;
    }
    public int getPagebegin() {
        return pagebegin;
    }
    public int getPageend() {
        return pageend;
    }
    public void setTotle(int totle) {
        this.totle = totle;
    }
    public void setPagebegin(int pagebegin) {
        this.pagebegin = pagebegin;
    }
    public void setPageend(int pageend) {
        this.pageend = pageend;
    }

    @Override
    public String toString() {
        return "PagesInfor{" +
                "totle=" + totle +
                ", pagebegin=" + pagebegin +
                ", pageend=" + pageend +
                '}';
    }
}
