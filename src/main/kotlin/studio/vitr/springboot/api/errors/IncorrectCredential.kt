package studio.vitr.springboot.api.errors

class IncorrectCredential(param: String): Error("incorrect credential $param")