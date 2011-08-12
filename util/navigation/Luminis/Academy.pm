package Luminis::Academy;

use strict;
use warnings;

require Exporter;

our $VERSION = '1.00';

our @ISA = qw(Exporter);
our @EXPORT_OK = qw(findGreatestSteppingStone nextSteppingStone);

sub currentBranch {
	my $branches = `git branch`;
	if ($branches =~ m/^\*\s(?<branch>\w+)/m) {
		return $+{'branch'}
	}
	return ""
}

sub findGreatestSteppingStone {
	my $branch = currentBranch();
	if ($branch) {
		my $tags = `git tag`;
		my $max = -1; my $steppingStone = "";
		while ($tags =~ /(?<steppingStone>$branch-(?<step>\d+))/gm) {
			my $step = int($+{'step'});
			if ((not $steppingStone) || $step > $max) {
				$max = $step;
				$steppingStone = $+{'steppingStone'};
			}
		}
		return $steppingStone;
	}
	return ""
}

sub nextSteppingStone {
	my $currentSteppingStone = shift(@_) || "";
	my $step = -1;
	if ($currentSteppingStone =~ /(?<step>\d+)/) {
		$step = $+{'step'};
	}
	$step++;
	return currentBranch() . "-" . $step;
}