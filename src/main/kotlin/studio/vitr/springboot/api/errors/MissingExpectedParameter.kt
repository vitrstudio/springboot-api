package studio.vitr.springboot.api.errors

class MissingExpectedParameter(param: String): Error("missing expected $param")