package app.learn;

public class Data {
  private String nim;
  private Float tugas;
  private Float uts;
  private Float uas;

  public Data(String nim, Float tugas, Float uts, Float uas) {
    this.nim = nim;
    this.tugas = tugas;
    this.uts = uts;
    this.uas = uas;
  }

  public String getNim() {
    return nim;
  }

  public Float getTugas() {
    return tugas;
  }

  public Float getUts() {
    return uts;
  }

  public Float getUas() {
    return uas;
  }
}
