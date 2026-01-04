package studio.vitr.springboot.api.errors

class InvalidParameter(param: String): Error("invalid $param")