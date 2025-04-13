package net.marco27.java.boilerplate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class JsonResponseResult implements Serializable {

    @Serial
    private static final long serialVersionUID = -3701044970580590871L;

    private final Object result;

}
