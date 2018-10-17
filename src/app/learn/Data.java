package app.learn;

import java.io.Serializable;

public class Data implements Serializable {
  private String nim;
  private Float tugas;
  private Float uts;
  private Float uas;
  private Float score;

  public Data() {
  }

  public Data(String nim, Float tugas, Float uts, Float uas) {
    this.nim = nim;
    this.tugas = tugas;
    this.uts = uts;
    this.uas = uas;
  }

  public void setNim(String nim) {
    this.nim = nim;
  }

  public void setTugas(Float tugas) {
    this.tugas = tugas;
  }

  public void setUts(Float uts) {
    this.uts = uts;
  }

  public void setUas(Float uas) {
    this.uas = uas;
  }

  public void setScore(Float score) {
    this.score = score;
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

  public Float getScore() {
    return score;
  }
}
