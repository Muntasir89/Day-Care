package com.example.daycare.Model;

public class StuModel {
    String ImgLink;
    String NameStu, IdStu, ContactStu, ClassStu;
    //Constructor
    public StuModel(){

    }

    public StuModel(String imgLink, String nameStu, String idStu, String contactStu, String classStu) {
        ImgLink = imgLink;
        NameStu = nameStu;
        IdStu = idStu;
        ContactStu = contactStu;
        ClassStu = classStu;
    }

    public String getImgStuLink() {
        return ImgLink;
    }

    public void setImgStuLink(String imgLink) {
        ImgLink = imgLink;
    }

    public String getNameStu() {
        return NameStu;
    }

    public void setNameStu(String nameStu) {
        NameStu = nameStu;
    }

    public String getIdStu() {
        return IdStu;
    }

    public void setIdStu(String idStu) {
        IdStu = idStu;
    }

    public String getContactStu() {
        return ContactStu;
    }

    public void setContactStu(String contactStu) {
        ContactStu = contactStu;
    }

    public String getClassStu() {
        return ClassStu;
    }

    public void setClassStu(String classStu){
        ClassStu = classStu;
    }
}
