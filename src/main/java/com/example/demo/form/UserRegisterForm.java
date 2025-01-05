package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterForm {

    @NotBlank(message = "ユーザー名を入力してください")  //未入力確認(空文字もケアする)
    private String userName;

    @NotBlank(message = "パスワードを入力してください")
    @Size(min = 8, message = "パスワードは少なくとも８文字必要です")
    private String password;

    @NotNull(message = "ロールを正しく取得出来きませんでした")  //未入力確認(空文字はケアしない)
    private Integer roleId;

}
