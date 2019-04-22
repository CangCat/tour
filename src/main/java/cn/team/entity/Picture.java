package cn.team.entity;

public class Picture {
    private Integer picId;

    private String picName;

    private String picUrl;

    private String picIntro;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getPicIntro() {
        return picIntro;
    }

    public void setPicIntro(String picIntro) {
        this.picIntro = picIntro == null ? null : picIntro.trim();
    }
}