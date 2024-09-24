package com.myfood.cqrs.myfood.command.infrastucture.exceptionHandler.ownException;

import com.myfood.cqrs.myfood.command.infrastucture.exceptionHandler.exceptionStructure.ErrorCode;

import lombok.Getter;

@Getter
public class ObjectNotFoundException extends RuntimeException {
  private final String messageKey;
  private final String code;

  public ObjectNotFoundException(ErrorCode code) {
    super(code.getCode());
    this.messageKey = code.getMessageKey();
    this.code = code.getCode();
  }

  public ObjectNotFoundException(final String message) {
    super(message);
    this.messageKey = ErrorCode.OBJECT_NOT_FOUND.getMessageKey();
    this.code = ErrorCode.OBJECT_NOT_FOUND.getCode();
  }
}
