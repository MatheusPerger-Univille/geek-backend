package br.univille.geekreviews.services;

import br.univille.geekreviews.services.exception.FileException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

@Service
public class S3Service {

    private Logger LOG = LoggerFactory.getLogger(S3Service.class);

    @Autowired
    private AmazonS3 s3Client;

    @Value("${s3.bucket}")
    private String bucketName;

    public URI uploadFile(MultipartFile multipartFile) {

        try {
            String fileName = Long.toString(Calendar.getInstance().getTimeInMillis());
            InputStream is = multipartFile.getInputStream();
            String contentType = multipartFile.getContentType();

            fileName = fileName + "." + multipartFile.getOriginalFilename().split("\\.")[1];

            return uploadFile(is, fileName, contentType);
        } catch (IOException e) {
            throw new FileException("Erro de IO: " + e.getMessage());
        }

    }

    public URI uploadFile(InputStream inputStream, String fileName, String contentType) {
        try {
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(contentType);

            LOG.info("Iniciando upload");
            s3Client.putObject(bucketName, fileName, inputStream, meta);
            LOG.info("Upload finalizado");
            return s3Client.getUrl(bucketName, fileName).toURI();
        } catch (URISyntaxException e) {
            throw new FileException("Erro ao converter URL para URI");
        }
    }

    public void deleteFile(String fileName) {
        try {
            String name = fileName.split("/")[3];
            s3Client.deleteObject(bucketName, name);
        } catch (Exception e) {
            throw new FileException("Erro ao excluir arquivo.");
        }
    }
}
