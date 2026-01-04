package studio.vitr.springboot.api.errors

class InvalidPayloadAttribute(attributeName: String, objectName: String): Error("invalid $attributeName in $objectName")