package studio.vitr.springboot.api.errors

class InvalidEnumValue(enumType: String, value: String): Error("invalid enum value: $enumType - $value")