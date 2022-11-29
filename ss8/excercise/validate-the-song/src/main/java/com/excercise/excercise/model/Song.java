package com.excercise.excercise.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "The song'name is not empty")
    @NotBlank(message = "The song'name is not blank")
    @Size(max = 800,message = "The song length can't more than 800 characters")
    @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]*([ ]+[a-zđáàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)+", message = "Name of the song must match Format ")
    private String songName;
    @NotEmpty(message = "Name is not empty")
    @NotBlank(message = "Name is not blank")
    @Size(max = 300,message = "Name'length can't more than 300 characters")
    @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$", message = "Name must match Format ")
    private String singer;


    @NotEmpty(message = "Category is not empty")
    @NotBlank(message = "Category is not blank")
    @Size(max = 1000,message = "Category'length can't more than 1000 characters")
    @Pattern(regexp = "^[A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ,]+([ ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ,]+[ ])+([a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$", message = "Name must match Format ")
    private String category;

    public Song() {
    }

    public Song(int id, @NotEmpty(message = "The song'name is not empty") @NotBlank(message = "The song'name is not blank") @Size(max = 800, message = "The song length can't more than 800 characters") @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]*([ ]+[a-zđáàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)+", message = "Name of the song must match Format ") String songName, @NotEmpty(message = "Name is not empty") @NotBlank(message = "Name is not blank") @Size(max = 300, message = "Name'length can't more than 300 characters") @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$", message = "Name must match Format ") String singer, @NotEmpty(message = "Category is not empty") @NotBlank(message = "Category is not blank") @Size(max = 1000, message = "Category'length can't more than 1000 characters") @Pattern(regexp = "^[A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ,]+([ ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ,]+[ ])+([a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$", message = "Name must match Format ") String category) {
        this.id = id;
        this.songName = songName;
        this.singer = singer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
