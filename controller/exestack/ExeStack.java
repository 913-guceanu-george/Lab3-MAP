package controller.exestack;

import model.statements.IStmt;

public class ExeStack implements IExeStack {

    private MyDeque<IStmt> stack;

    public ExeStack() {
        this.stack = new MyDeque<IStmt>();
    }

    @Override
    public IStmt removeLast() {
        return this.stack.removeLast();
    }

    @Override
    public IStmt removeFirst() {
        return this.stack.removeFirst();

    }

    @Override
    public void addLast(IStmt statement) {
        this.stack.addLast(statement);
    }

    @Override
    public void addFirst(IStmt statement) {
        this.stack.addFirst(statement);
    }

    public int size() {
        return this.stack.size();
    }
}
