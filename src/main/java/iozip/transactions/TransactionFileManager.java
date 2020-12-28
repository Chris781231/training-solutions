package iozip.transactions;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class TransactionFileManager {

    public void saveTransactions(Path file, List<Transaction> transactions) {
        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            for (Transaction transaction : transactions) {
                zos.putNextEntry(new ZipEntry(Long.toString(transaction.getId())));
                zos.write((transaction.getTime().toString() + "\n").getBytes());
                zos.write((transaction.getAccount() + "\n").getBytes());
                zos.write((transaction.getAmount() + "\n").getBytes());
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Can not read file", ioe);
        }
    }
}
