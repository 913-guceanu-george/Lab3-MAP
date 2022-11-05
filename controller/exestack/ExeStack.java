package controller.exestack;

import model.statements.*;

public class ExeStack implements IExeStack {

    private MyDeque<IStmt> stack;

    public ExeStack() {
        this.stack = new MyDeque<IStmt>();
    }

    @Override
    public void removeLast() {
        IStmt comp = this.stack.getLast();
        if (comp.getWords()[0] == "If") {
            
        }
    }

    @Override
    public void removeFirst() {
        // TODO Auto-generated method stub

    }

    @Override
    public void addLast(IStmt statement) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addFirst(IStmt statement) {
        // TODO Auto-generated method stub

    }

}
