package controller.exestack;

import model.statements.*;

public interface IExeStack {
    public void removeLast();

    public void removeFirst();

    public void addLast(IStmt statement);

    public void addFirst(IStmt statement);
}
