package thread.exercises.goteborg.infoDisplay;

public interface HWDisplay {
    public int getRows();
    public int getCols();
    public void write(int row, int col, char c);
}
