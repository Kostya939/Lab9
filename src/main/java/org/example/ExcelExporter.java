package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.*;

public class ExcelWriter {

    public void exportDataToExcel(List<Customer> customers, File file) throws IOException {
        Workbook workbook = new Workbook() {
            @Override
            public int getActiveSheetIndex() {
                return 0;
            }

            @Override
            public void setActiveSheet(int i) {

            }

            @Override
            public int getFirstVisibleTab() {
                return 0;
            }

            @Override
            public void setFirstVisibleTab(int i) {

            }

            @Override
            public void setSheetOrder(String s, int i) {

            }

            @Override
            public void setSelectedTab(int i) {

            }

            @Override
            public void setSheetName(int i, String s) {

            }

            @Override
            public String getSheetName(int i) {
                return null;
            }

            @Override
            public int getSheetIndex(String s) {
                return 0;
            }

            @Override
            public int getSheetIndex(Sheet sheet) {
                return 0;
            }

            @Override
            public Sheet createSheet() {
                return null;
            }

            @Override
            public Sheet createSheet(String s) {
                return null;
            }

            @Override
            public Sheet cloneSheet(int i) {
                return null;
            }

            @Override
            public Iterator<Sheet> sheetIterator() {
                return null;
            }

            @Override
            public int getNumberOfSheets() {
                return 0;
            }

            @Override
            public Sheet getSheetAt(int i) {
                return null;
            }

            @Override
            public Sheet getSheet(String s) {
                return null;
            }

            @Override
            public void removeSheetAt(int i) {

            }

            @Override
            public Font createFont() {
                return null;
            }

            @Override
            public Font findFont(boolean b, short i, short i1, String s, boolean b1, boolean b2, short i2, byte b3) {
                return null;
            }

            @Override
            public int getNumberOfFonts() {
                return 0;
            }

            @Override
            public int getNumberOfFontsAsInt() {
                return 0;
            }

            @Override
            public Font getFontAt(int i) {
                return null;
            }

            @Override
            public CellStyle createCellStyle() {
                return null;
            }

            @Override
            public int getNumCellStyles() {
                return 0;
            }

            @Override
            public CellStyle getCellStyleAt(int i) {
                return null;
            }

            @Override
            public void write(OutputStream outputStream) throws IOException {

            }

            @Override
            public void close() throws IOException {

            }

            @Override
            public int getNumberOfNames() {
                return 0;
            }

            @Override
            public Name getName(String s) {
                return null;
            }

            @Override
            public List<? extends Name> getNames(String s) {
                return null;
            }

            @Override
            public List<? extends Name> getAllNames() {
                return null;
            }

            @Override
            public Name createName() {
                return null;
            }

            @Override
            public void removeName(Name name) {

            }

            @Override
            public int linkExternalWorkbook(String s, Workbook workbook) {
                return 0;
            }

            @Override
            public void setPrintArea(int i, String s) {

            }

            @Override
            public void setPrintArea(int i, int i1, int i2, int i3, int i4) {

            }

            @Override
            public String getPrintArea(int i) {
                return null;
            }

            @Override
            public void removePrintArea(int i) {

            }

            @Override
            public Row.MissingCellPolicy getMissingCellPolicy() {
                return null;
            }

            @Override
            public void setMissingCellPolicy(Row.MissingCellPolicy missingCellPolicy) {

            }

            @Override
            public DataFormat createDataFormat() {
                return null;
            }

            @Override
            public int addPicture(byte[] bytes, int i) {
                return 0;
            }

            @Override
            public List<? extends PictureData> getAllPictures() {
                return null;
            }

            @Override
            public CreationHelper getCreationHelper() {
                return null;
            }

            @Override
            public boolean isHidden() {
                return false;
            }

            @Override
            public void setHidden(boolean b) {

            }

            @Override
            public boolean isSheetHidden(int i) {
                return false;
            }

            @Override
            public boolean isSheetVeryHidden(int i) {
                return false;
            }

            @Override
            public void setSheetHidden(int i, boolean b) {

            }

            @Override
            public SheetVisibility getSheetVisibility(int i) {
                return null;
            }

            @Override
            public void setSheetVisibility(int i, SheetVisibility sheetVisibility) {

            }

            @Override
            public void addToolPack(UDFFinder udfFinder) {

            }

            @Override
            public void setForceFormulaRecalculation(boolean b) {

            }

            @Override
            public boolean getForceFormulaRecalculation() {
                return false;
            }

            @Override
            public SpreadsheetVersion getSpreadsheetVersion() {
                return null;
            }

            @Override
            public int addOlePackage(byte[] bytes, String s, String s1, String s2) throws IOException {
                return 0;
            }

            @Override
            public EvaluationWorkbook createEvaluationWorkbook() {
                return null;
            }

            @Override
            public CellReferenceType getCellReferenceType() {
                return null;
            }

            @Override
            public void setCellReferenceType(CellReferenceType cellReferenceType) {

            }
        };

        Sheet sheet = workbook.createSheet("Customers");

        int row = 0;
        for (Customer customer : customers) {
            Row rowData = sheet.createRow(row++);
            rowData.createCell(0).setCellValue(customer.getId());
            rowData.createCell(1).setCellValue(customer.getName());
            rowData.createCell(2).setCellValue(customer.getEmail());
            rowData.createCell(3).setCellValue(customer.getPhone());
        }

        file = new File("customers.xlsx");
        FileOutputStream outputStream = new FileOutputStream(file);
    }
}

