static TypeName get(Type type, Map<Type, TypeVariableName> map) {
    if (type instanceof Class<?>) {
        Class<?> classType = (Class<?>) type;
        if (type == void.class)
            return VOID;
        if (type == boolean.class)
            return BOOLEAN;
        if (type == byte.class)
            return BYTE;
        if (type == short.class)
            return SHORT;
        if (type == int.class)
            return INT;
        if (type == long.class)
            return LONG;
        if (type == char.class)
            return CHAR;
        if (type == float.class)
            return FLOAT;
        if (type == double.class)
            return DOUBLE;
        if (classType.isArray())
            return ArrayTypeName.of(get(classType.getComponentType(), map));
        return ClassName.get(classType);

    } else if (type instanceof ParameterizedType) {
        return ParameterizedTypeName.get((ParameterizedType) type, map);

    } else if (type instanceof WildcardType) {
        return WildcardTypeName.get((WildcardType) type, map);

    } else if (type instanceof TypeVariable<?>) {
        return TypeVariableName.get((TypeVariable<?>) type, map);

    } else if (type instanceof GenericArrayType) {
        return ArrayTypeName.get((GenericArrayType) type, map);

    } else {
        throw new IllegalArgumentException("unexpected type: " + type);
    }
}