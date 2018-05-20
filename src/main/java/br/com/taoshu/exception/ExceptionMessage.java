package br.com.taoshu.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Avell 1513 on 17/05/2018.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ExceptionMessage {
    private String message;
    private String detail;
}
