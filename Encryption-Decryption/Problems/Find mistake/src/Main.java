class Test {

    public static void main(String[] args) {
        new Programmer(1);
    }

    public static class TeamLead {
        private int numTeamLead;

        public TeamLead(int numTeamLead) {
            this.numTeamLead = numTeamLead;
            employ();  // if we call new Programmer(1), employ() will also print 1 programmer, i.e. method of instantiated object
        }

        private void employ() {
            System.out.println(numTeamLead + " teamlead");
        }

    }

    public static class Programmer extends TeamLead {
        private int numProgrammer;

        public Programmer(int numProgrammer) {
            super(numProgrammer);
            this.numProgrammer = numProgrammer;
            employ();
        }

        protected void employ() {
//            super.employ();
            System.out.println(numProgrammer + " programmer");
        }
    }
}
