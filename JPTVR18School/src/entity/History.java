package entity;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable{
    private Hind hind;
    private Reader reader;
    private Date takeOnDate;
    private Date returnDate;

    public History() {
    }

    public History(Hind hind, Reader reader, Date takeOnDate, Date returnDate) {
        this.hind = hind;
        this.reader = reader;
        this.takeOnDate = takeOnDate;
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Hind getHind() {
        return hind;
    }

    public void setHind(Hind hind) {
        this.hind = hind;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getTakeOnDate() {
        return takeOnDate;
    }

    public void setTakeOnDate(Date takeOnDate) {
        this.takeOnDate = takeOnDate;
    }

    @Override
    public String toString() {
        return "History{"
                + "hind=" + hind.getName()
                + ", reader=" + reader.getName()+" "+reader.getLastname()
                + ", takeOnDate=" + takeOnDate
                + ", returnDate=" + returnDate
                + '}';
    }

    /**
     *
     * @param hind
     */
}