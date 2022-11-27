package controller.filetable;

import java.util.HashMap;

public class FileTable<Str, Reader> implements IFileTable<Str, Reader> {

    private HashMap<Str, Reader> filetable;

    public FileTable() {
        this.filetable = new HashMap<>();
    }

    @Override
    public void add(Str filename, Reader buffer) {
        this.filetable.put(filename, buffer);
    }

    @Override
    public Reader get(Str filename) {
        return this.filetable.get(filename);
    }

}