package com.sokolowska.sageszadanie.io;

import com.sokolowska.sageszadanie.domain.NewsDto;
import com.sokolowska.sageszadanie.domain.SingleNewsDto;
import com.sokolowska.sageszadanie.exception.NewsSaveException;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Component
public class NewsWriter {

    private static final String FILE_NAME = "news-" + LocalDate.now() + ".txt";

    public void saveNews(NewsDto newsDto) {
        List<SingleNewsDto> news = newsDto.getArticles();

        try (FileWriter fileWriter = new FileWriter(FILE_NAME);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (SingleNewsDto singleNews : news) {
                bufferedWriter.write(singleNews.getTitle() + ":" +
                        singleNews.getDescription() + ":" +
                        singleNews.getAuthor()
                );
                bufferedWriter.newLine();
            }
            System.out.println("************ Dane poprawnie zapisane do pliku **************");
        } catch (IOException e) {
            throw new NewsSaveException("Błąd zapisu danych do pliku " + FILE_NAME);
        }
    }


}
