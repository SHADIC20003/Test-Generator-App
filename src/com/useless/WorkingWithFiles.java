package project3;




public class WorkingWithFiles {
     private String filepathQ;
    private String filepathA;

    WorkingWithFiles(String filepathQ,String filepathA){
        this.filepathQ = filepathQ;
        this.filepathA = filepathA;

    }


    public String getFilepathQ() {
        return filepathQ;
    }

    public void setFilepathQ(String filepathQ) {
        this.filepathQ = filepathQ;
    }

    public String getFilepathA() {
        return filepathA;
    }

    public void setFilepathA(String filepathA) {
        this.filepathA = filepathA;
    }

}

