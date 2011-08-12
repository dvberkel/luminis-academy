#! /usr/bin/env perl

use strict;
use warnings;

my $branches = `git branch`;
if ($branches =~ m/^\*\s(?<branch>\w+)/m) {
	my $branch = $+{'branch'};
	print "$branch\n"
} else {
	print "unknown"
}