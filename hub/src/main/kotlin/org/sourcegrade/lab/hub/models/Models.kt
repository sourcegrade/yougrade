package org.sourcegrade.lab.hub.models

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import java.util.UUID

open class Models : IdTable<String> {
    constructor() : super()
    constructor(name: String) : super(name)

    final override val id: Column<EntityID<String>> =
        varchar("id", 36)
            .clientDefault { UUID.randomUUID().toString() }.entityId()
    override val primaryKey = PrimaryKey(id, name = "pk_${tableName}_id")
}

abstract class Model<T>(id: EntityID<String>) : Entity<String>(id) {
    abstract fun toDTO(): T
}

// TODO: add https://github.com/JetBrains/Exposed/issues/497#issuecomment-520266191
