public class Wizard extends Player {
    private String spell;
    private SpellLibrary spellLibrary;


    public Wizard(int health, int strength, int lives, String spell, SpellLibrary spellLibrary) {
        super(health, strength, lives);
        this.spell = spell;
        this.spellLibrary = spellLibrary;
    }


    public Wizard(int health, int strength, int lives, String spell) {
        super(health, strength, lives);
        this.spell = spell;
        // No spell library is provided
        this.spellLibrary = null;
    }


    public String getSpell() {
        return spell;
    }


    public void setSpell(String spell) {
        this.spell = spell;
    }


    public void setSpellLibrary(SpellLibrary spellLibrary) {
        this.spellLibrary = spellLibrary;
    }


    public Elf convertToElf() {
        return new Elf(getHealth(), getStrength(), getLives(), 8); // Default speed value
    }


    public String castRandomSpell() {
        if (spellLibrary == null) {
            throw new IllegalStateException("No spell library available");
        }
        return "Casting " + spellLibrary.getRandomSpell();
    }
}