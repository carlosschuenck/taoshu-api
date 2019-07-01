package br.com.taoshu.exception;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avell 1513 on 17/05/2018.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
class ExceptionMessage {
    private List<String> mensagens = new ArrayList<>();
    private List<String> mendagensDesenvolvedor = new ArrayList<>();
}
