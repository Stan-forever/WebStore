package POJO;

public class SrechModel {
    private  int pagesize;//页数
    private  int Pagesindex;//起始数
    private String SrechaStr;//检索条件

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getSrechaStr() {
        return SrechaStr;
    }

    public void setSrechaStr(String srechaStr) {
        SrechaStr = srechaStr;
    }

    public void setPagesindex(int pagesindex) {
        Pagesindex = pagesindex;
    }

    public int getPagesindex() {
        return Pagesindex;
    }
}
