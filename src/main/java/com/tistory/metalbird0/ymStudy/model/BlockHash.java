package com.tistory.metalbird0.ymStudy.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlRootElement(name = "BlockHash")
public class BlockHash {

    @XmlElement(name = "HashValue", required = true)
    private String hashValue;
    @XmlElement(name = "Size", required = true)
    private int size;
    
    public BlockHash() {}
    public BlockHash(String value) {
        this.hashValue = value;
    }
    public BlockHash(String value, int size) {
        this.hashValue = value;
        this.size = size;
    }
    public String getHashValue() {
        return hashValue;
    }
    public void setHashValue(String hashValue) {
        this.hashValue = hashValue;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    
}
