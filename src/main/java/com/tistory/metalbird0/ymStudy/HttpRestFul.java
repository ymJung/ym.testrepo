package com.tistory.metalbird0.ymStudy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import com.tistory.metalbird0.ymStudy.model.BlockHash;
import com.tistory.metalbird0.ymStudy.model.Content;

public class HttpRestFul {

    public void download(String sourceUrl, String xmlStr) throws ClientProtocolException, IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost(sourceUrl);
        post.setHeader("Content-Type", "application/xml");
        //        HttpEntity entity = new StringEntity(xmlStr);
        HttpEntity entity = new ByteArrayEntity(xmlStr.getBytes());
        post.setEntity(entity);

        InputStream is = null;
        OutputStream os = null;
        try {
            HttpResponse response = httpClient.execute(post);
            is = response.getEntity().getContent();
            os = new FileOutputStream("/Dev/workspace/ymStudy/WebContent/META-INF/concatfile");
            IOUtils.copy(is, os);
            os.flush();
            System.out.println("\n Download complete.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
            is.close();
            //            Closeables.closeQuietly(os);
            //            Closeables.closeQuietly(is);
        }
    }

    public static void main(String[] args) {
        String blockUrl = "http://localhost:19380/sa/func/concat";
        String xml = "";
        HttpRestFul rest = new HttpRestFul();
        Content content = new Content();
        List<BlockHash> blockHashList = new ArrayList<>();
        blockHashList.add(new BlockHash("-xIXM34yBuEDe_8wg3o8y23ma6epWgoANY3YEHIyHPM"));
        blockHashList.add(new BlockHash("jDpyKzyGSPHC-qsTLkgVDGgx9KEVQEyD3hjODgUAAKo"));
        blockHashList.add(new BlockHash("BPOCa24YoOwjJrnVdne60zV1ylKVKl5VXypySiIBYJw"));
        blockHashList.add(new BlockHash("fuyqDBoYNexY9M6BDNTU9xIV37tk_k3TvnfGpgp6C2o"));
        
        content.setBlockHashList(blockHashList);

        xml = convertObjectToXml(content);
        System.out.println(xml);
        try {
            rest.download(blockUrl, xml);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertObjectToXml(Object object) {
        try {
            StringBuffer strBuffer = new StringBuffer();
            StringWriter stringWriter = new StringWriter();
            JAXBContext jaxbContextRequest = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContextRequest.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, stringWriter);
            String xml = stringWriter.toString();
            strBuffer.append(xml);
            return strBuffer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object.toString();
    }
}
