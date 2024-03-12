
export class Astracta{

    constructor(){
        if (this.constructor=== Astracta)
            throw new Error ("La clase personaA es abstracto");
    }
        habla(){
            throw new Error ("Este es un método abstracto y se debe sobreescribir en las subclases");
        }
    
}

