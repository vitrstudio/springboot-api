package studio.vitr.springboot.api.errors

class Forbidden(id: String) : Error("access forbidden for user $id")