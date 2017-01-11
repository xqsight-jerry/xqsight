package com.xqsight.common.upload.support;

import com.xqsight.common.upload.GlobalUpload;
import com.xqsight.common.upload.service.UploadConfige;
import com.xqsight.common.upload.handler.FileHandler;
import com.xqsight.common.upload.file.FtpTemplate;
import com.xqsight.common.upload.image.WatermarkParam;
import com.xqsight.common.upload.service.PathResolver;
import com.xqsight.commons.web.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangganggang on 2017/1/11.
 */
public class UploadSupport {

    @Autowired
    private static UploadConfige sysUploadInfo;

    public static WatermarkParam getWatermarkParam(Boolean watermark) {
        return new WatermarkParam(watermark);
        /*return new WatermarkParam(watermark, getImagePath(), getAlpha(),
                getPosition(), getPaddingX(), getPaddingY(), getMinWidth(),
                getMinHeight());*/
    }

    public static GlobalUpload getGlobalUpload() {
        return new GlobalUpload();
    }

    public static FtpTemplate getFtpTemplate() {
        return new FtpTemplate(sysUploadInfo.getFtpHostName(), sysUploadInfo.getFtpPort(), sysUploadInfo.getFtpUserName(), sysUploadInfo.getFtpPassword());
    }

    public static FileHandler getFileHandler(PathResolver pathResolver) {
        String prefix = sysUploadInfo.getStorePath();
        FileHandler fileHandler;
        if (sysUploadInfo.isFtpMethod()) {
            fileHandler = FileHandler.getFileHandler(getFtpTemplate(), prefix);
        } else {
            fileHandler = FileHandler.getLocalFileHandler(pathResolver, prefix);
        }
        return fileHandler;
    }

    public static String getUrlPrefix() {
        StringBuilder sb = new StringBuilder();
        if (!sysUploadInfo.isFtpMethod() && !StringUtils.startsWith(sysUploadInfo.getStorePath(), "file:")) {
            String ctx = WebUtils.getCtx();
            if (StringUtils.isNotBlank(ctx)) {
                sb.append(ctx);
            }
        }
        String displayPath = sysUploadInfo.getDisplayPath();
        if (StringUtils.isNotBlank(displayPath)) {
            sb.append(displayPath);
        }
        return sb.toString();
    }

    public static int getSystemId() {
        return 1;
    }

    public static String getSiteBase(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("/").append(getSystemId());
        if (StringUtils.isNotBlank(path)) {
            if (!path.startsWith("/")) {
                sb.append("/");
            }
            sb.append(path);
        }
        return sb.toString();
    }

    public boolean isFtp() {
        return sysUploadInfo.isFtpMethod();
    }
}
