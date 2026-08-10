package com.traintracker.backend.dto;

public class ImportSummaryResponse {

    private int totalRows;
    private int imported;
    private int skipped;
    private String message;

    public ImportSummaryResponse() {
    }

    public ImportSummaryResponse(int totalRows, int imported, int skipped, String message) {
        this.totalRows = totalRows;
        this.imported = imported;
        this.skipped = skipped;
        this.message = message;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getImported() {
        return imported;
    }

    public void setImported(int imported) {
        this.imported = imported;
    }

    public int getSkipped() {
        return skipped;
    }

    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}