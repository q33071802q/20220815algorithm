package design.strategy;



public class Execurise2 {

}

abstract class ExportTemplate{
    public final void export(){
        loadData();
        formatData();
        writeFile();
    }

    protected abstract void loadData() ;
    protected abstract void formatData() ;
    protected abstract void writeFile() ;


}

interface DataLoader{
    void loadData();
}

interface DataFormatter{
    void formatData();
}

interface FileWriter{
    void writeFile();
}

class Exprocessor{
    protected DataLoader dataLoader;
    protected DataFormatter formatter;
    protected FileWriter fileWriter;

    public Exprocessor(DataLoader dataLoader, DataFormatter formatter, FileWriter fileWriter) {
        this.dataLoader = dataLoader;
        this.formatter = formatter;
        this.fileWriter = fileWriter;
    }

    public final void export(){
        dataLoader.loadData();
        formatter.formatData();
        fileWriter.writeFile();
    }

    public static void main(String[] args) {
        Exprocessor exprocessor = new Exprocessor(new DataLoader() {
            @Override
            public void loadData() {
                System.out.println("load data");
            }
        }, new DataFormatter() {
            @Override
            public void formatData() {
                System.out.println("format data");
            }
        }, new FileWriter() {
            @Override
            public void writeFile() {
                System.out.println("write data");
            }
        });
        exprocessor.export();
    }
}
