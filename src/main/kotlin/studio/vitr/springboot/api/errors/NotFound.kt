package studio.vitr.springboot.api.errors

class NotFound(entity: String, id: String): Error("$entity $id not found")