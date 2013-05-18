package org.pronto.core.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.pronto.core.exception.FailTestException;

public class WriterLog {
	private File file;
	private FileWriter fw;

	public void SetUpWriterLog(String sPath) throws FailTestException {
		try {
			file = new File(sPath);
			fw = new FileWriter(file);
		} catch (NullPointerException exc) {
			System.out.println("�� ������� ������� ���� ����");
			throw new FailTestException("�� ������� ������� ���� ����");
		} catch (IOException exc) {
			System.out.println("�� ������� ������� ���� ����");
			throw new FailTestException("�� ������� ������� ���� ����");
		}
		System.out.println("������� ���� ����");
		// charset=utf-8
		WriteString(
				0,
				"<html><head><meta http-equiv=\"Content-Type\" content=\"text/html;\"><title>Log_Result</title></head><body>");
		WriteString(
				0,
				"<style> pre {margin:0;padding:0; font-family:arial; font: arial 18px/16px;} </style>");
	}

	public void WriteString(int iTypeOfString, String sMessage)
			throws FailTestException {
		try {
			switch (iTypeOfString) {
			case 1:
				fw.write("<pre style=\"color:green\">" + sMessage + "</pre>"
						+ "\n");
				break;
			case 2:
				fw.write("<pre style=\"color:red\">" + sMessage + "</pre>"
						+ "\n");
				break;
			case 3:
				fw.write("<pre style=\"color:blue\">" + sMessage + "</pre>"
						+ "\n");
				break;
			case 4:
				fw.write("<pre style=\"color:yellow\">" + sMessage + "</pre>"
						+ "\n");
				break;
			default:
				fw.write(sMessage + "\n");
				break;
			}
		} catch (IOException exc) {
			System.out.println("�� ������� �������� � ���� ����: " + sMessage);
			throw new FailTestException("�� ������� �������� � ���� ����: "
					+ sMessage);
		}
	}

	public void CloseFile() throws FailTestException {
		WriteString(0, "</body></html>");
		System.out.println("��������� ���� ����");
		try {
			fw.close();
		} catch (IOException exc) {
			System.out.println("�� ������� ������� ���� ����");
		}
	}
}
