package studio.vitr.springboot.api.model.api

class Health(
    val status: HealthStatus,
    val version: String
)