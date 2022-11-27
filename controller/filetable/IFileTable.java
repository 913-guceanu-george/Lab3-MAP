package controller.filetable;

public interface IFileTable<Str, Reader> {
    public void add(Str filename, Reader buffer);

    public Reader get(Str filename);

}
