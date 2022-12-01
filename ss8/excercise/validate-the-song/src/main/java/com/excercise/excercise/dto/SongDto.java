package com.excercise.excercise.dto;

import com.excercise.excercise.model.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto implements Validator  {
    private int id;
    @NotEmpty(message = "The song'name is not empty")
    @NotBlank(message = "The song'name is not blank")
    @Size(max = 800,message = "The song length can't more than 800 characters")
//    @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]*([ ]+[a-zđáàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)+", message = "Name of the song must match Format ")
    private String songName;
    @NotEmpty(message = "Name is not empty")
    @NotBlank(message = "Name is not blank")
    @Size(max = 300,message = "Name'length can't more than 300 characters")
    @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$", message = "Name must match Format ")
    private String singer;


    @NotEmpty(message = "Category is not empty")
    @NotBlank(message = "Category is not blank")
    @Size(max = 1000,message = "Category'length can't more than 1000 characters")
    @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩị.đùúủũụưứửữựỷỹ0-9,]*([ ]+[a-zđáàảãạăâẩắằấầặ,ẵẫậéèẻẽẹếềểễệóòêỏõọô.ốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)*", message = "Name must match Format ")
    private String category;

    public SongDto() {
    }

    public SongDto(@NotEmpty(message = "The song'name is not empty") @NotBlank(message = "The song'name is not blank") @Size(max = 800, message = "The song length can't more than 800 characters") @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]*([ ]+[a-zđáàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)+", message = "Name of the song must match Format ") String songName, @NotEmpty(message = "Name is not empty") @NotBlank(message = "Name is not blank") @Size(max = 300, message = "Name'length can't more than 300 characters") @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$", message = "Name must match Format ") String singer, @NotEmpty(message = "Category is not empty") @NotBlank(message = "Category is not blank") @Size(max = 1000, message = "Category'length can't more than 1000 characters") @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩị.đùúủũụưứửữựỷỹ0-9,]*([ ]+[a-zđáàảãạăâẩắằấầặ,ẵẫậéèẻẽẹếềểễệóòêỏõọô.ốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)+", message = "Name must match Format ") String category) {
        this.songName = songName;
        this.singer = singer;
        this.category = category;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto  = (SongDto) target;
        if(!songDto.getSongName().matches("^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]*([ ]+[a-zđáàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)+")){
            errors.rejectValue("songName","songName","Name of the song must match Format !!!! ");
        }
    }

    public SongDto(int id, @NotEmpty(message = "The song'name is not empty") @NotBlank(message = "The song'name is not blank") @Size(max = 800, message = "The song length can't more than 800 characters") String songName, @NotEmpty(message = "Name is not empty") @NotBlank(message = "Name is not blank") @Size(max = 300, message = "Name'length can't more than 300 characters") @Pattern(regexp = "^([A-ZĐ][a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ]+[ ]*)+([A-ZĐ][a-záàảãạăâẩắằấầặẵẫậéèẻẽẹếềểễệóòêỏõọôốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ])*+$", message = "Name must match Format ") String singer, @NotEmpty(message = "Category is not empty") @NotBlank(message = "Category is not blank") @Size(max = 1000, message = "Category'length can't more than 1000 characters") @Pattern(regexp = "^[A-ZĐ0-9]+[a-záàảãạăâẩắằấầặẵẫêậéèẻẽẹếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩị.đùúủũụưứửữựỷỹ0-9,]*([ ]+[a-zđáàảãạăâẩắằấầặ,ẵẫậéèẻẽẹếềểễệóòêỏõọô.ốồổỗộơớờởỡợíìỉĩịđùúủũụưứửữựỷỹ0-9]+)*", message = "Name must match Format ") String category) {
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
}
