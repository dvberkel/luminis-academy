#! /usr/bin/env perl

use strict;
use warnings;

use FindBin qw($Bin);
use lib "$Bin";

use Getopt::Long;
use Luminis::Academy qw(createCourse);

my $branch = 'master';
my $course;

GetOptions("course=s" => \$course, "branch=s" => \$branch);

if (not $course) {
	die <<EOU
usage: $0 --course <name> [--branch <branch-name>]
where:
	- name:        will be the name of the course to start
	- branch-name: will start the branch from the git branch.
EOU
;
}

createCourse($course,$branch);