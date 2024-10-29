package Memento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<String> historyTime;
    private List<IMemento> redohistory;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.redohistory = new ArrayList<>();
        this.history = new ArrayList<>();
        this.historyTime = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
        redohistory.clear();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
        redohistory.clear();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            saveToRedoHistory();
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            historyTime.remove(historyTime.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        if (!redohistory.isEmpty()) {
            saveToHistory();
            IMemento nextState = redohistory.remove(redohistory.size() - 1);
            historyTime.remove(historyTime.size() - 1);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToRedoHistory() {
        IMemento currentState = model.createMemento();
        redohistory.add(currentState);
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        historyTime.add("State at " + timeStamp);
    }

    public List<String> getHistoryTime() {
        return historyTime;
    }

    public void restoreStateFromTime(String time) {
        int index = historyTime.indexOf(time);
        IMemento stateToRestore = history.get(index);
        model.restoreState(stateToRestore);
        gui.updateGui();
    }

    public void removeState(int index) {
        history.remove(index);
        historyTime.remove(index);
    }
}

