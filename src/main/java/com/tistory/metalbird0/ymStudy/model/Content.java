package com.tistory.metalbird0.ymStudy.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content", propOrder = {"blockHashList"})
@XmlRootElement(name = "Content")
public class Content {
    @XmlElementWrapper(name = "BlockHashList", required = false)
    @XmlElement(name = "Block", required = false)
    private List<BlockHash> blockHashList;

    public List<BlockHash> getBlockHashList() {
        return blockHashList;
    }

    public void setBlockHashList(List<BlockHash> blockHashList) {
        this.blockHashList = blockHashList;
    }
}
