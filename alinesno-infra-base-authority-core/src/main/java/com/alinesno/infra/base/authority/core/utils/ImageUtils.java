package com.alinesno.infra.base.authority.core.utils;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Base64;
import java.util.UUID;

@Slf4j
public class ImageUtils {

    private static final int MAX_SIZE_IN_KB = 40; // 图片最大大小 40 KB

    /**
     * 获取图片的 Base64 编码。
     * 如果图片大于指定大小，则进行压缩。
     *
     * @param imageUrl 图片 URL
     * @return 图片的 Base64 编码
     * @throws IOException 如果读取图片失败
     */
    @SneakyThrows
    public static String getImageAsBase64(String imageUrl) {

        File tempFile = new File(downloadImage(imageUrl));
        BufferedImage image = ImageIO.read(tempFile);

        File file = FileUtil.file(tempFile);
        String imageFormat = FileTypeUtil.getType(file);

        // 检查图片大小
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, imageFormat , baos);
        byte[] imageData = baos.toByteArray();
        long imageSizeInKB = imageData.length / 1024L;

        if (imageSizeInKB > MAX_SIZE_IN_KB) {
            // 压缩图片
            BufferedImage compressedImage = Thumbnails.of(image)
                    .scale(0.5) // 调整比例以减小文件大小
                    .asBufferedImage();

            // 重写压缩后的图片到字节数组
            baos.reset();
            ImageIO.write(compressedImage, imageFormat , baos);
            imageData = baos.toByteArray();
        }

        // 将字节数组转换为 Base64 字符串
        return Base64.getEncoder().encodeToString(imageData);
    }

    public static String downloadImage(String imageUrl) {
        String tempDirPath = System.getProperty("java.io.tmpdir");
        String destinationFile = tempDirPath + File.separator + UUID.randomUUID(); // 保存的文件名

        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(imageUrl).openStream());
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            log.debug("图片下载成功！, path = " + destinationFile);
        } catch (IOException e) {
            log.debug("图片下载失败！{}" , e.getMessage());
        }

        return destinationFile;
    }

}