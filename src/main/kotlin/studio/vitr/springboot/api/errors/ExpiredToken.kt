package studio.vitr.springboot.api.errors

class ExpiredToken(tokenType: String) : Error("$tokenType is expired")